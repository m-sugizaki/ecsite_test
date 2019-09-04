package jp.co.bow.ec.controller;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.bow.ec.entity.ProductEntity;
import jp.co.bow.ec.entity.Product_CartEntity;
import jp.co.bow.ec.entity.ReviewEntity;
import jp.co.bow.ec.entity.UserEntity;
import jp.co.bow.ec.model.ProductInfoModel;
import jp.co.bow.ec.model.SearchProductInfoModel;
import jp.co.bow.ec.service.SearchProductService;

@Controller
@SessionAttributes({"products","userEntity"})
public class SearchProductController {

	@Autowired
	SearchProductService searchProductService;

	@ModelAttribute("searchProductInfoModel")
	public SearchProductInfoModel setUpSearchProductInfoModel() {
		return new SearchProductInfoModel();
	}

	@ModelAttribute("productInfoModel")
	public ProductInfoModel setProductInfoModel() {
		return new ProductInfoModel();
	}

	//商品検索画面表示
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String toSearchProduct(Model model) {
		return "searchProduct";
	}

	//商品詳細画面に遷移
	@RequestMapping(value="/detail",method=RequestMethod.POST,params="detail")
	public String toProductInfo(@ModelAttribute ProductInfoModel productInfoModel, Model model) {

		//商品コードの一致する商品の詳細情報を取得
		ProductEntity product = searchProductService.findOneProduct(productInfoModel.getProduct_id());
		/*データベースから取得した画像のデータを16進数から64進数に変換する
		   これによってサイトのパフォーマンスが向上する*/
		product.setBase64string(Base64.getEncoder().encodeToString(product.getImage()));
		model.addAttribute("product",product);

		//サイズのプルダウン
		List<String> size =Arrays.asList(product.getSize().split(","));
		model.addAttribute("size",size);

		//カラーのプルダウン
		List<String> color =Arrays.asList(product.getColor().split(","));
		model.addAttribute("color",color);

		//商品コードの一致する商品の口コミを取得
		//List<ReviewEntity> review = searchProductService.getReview(searchProductInfoModel.getProduct_id());
		//model.addAttribute("review",review);

		return "productInfo";//商品詳細画面遷移
	}

	//条件入力した場合に、当てはまるデータと照合。未入力なら全データ表示
	@RequestMapping(value="/search",method=RequestMethod.POST,params="kensaku")
	public String getSearchResult(@ModelAttribute SearchProductInfoModel searchProductInfoModel, Model model, RedirectAttributes attributes) {
		ProductEntity entity=new ProductEntity();
		entity.setProduct_name(searchProductInfoModel.getProduct_name());
		entity.setMaker(searchProductInfoModel.getMaker());
		String ps= searchProductInfoModel.getPrice_start();//最低価格
		String pe= searchProductInfoModel.getPrice_end();//最大価格
		//条件入力した場合に、当てはまるデータと照合。未入力なら全データ表示
		if(ps.isEmpty() && pe.isEmpty()) {
			//最低価格に何も入力しない場合、強制的に0を入力させる
			ps = "0";
			entity.setPrice_start(Integer.parseInt(ps));
			//最大価格に何も入力しない場合、強制的に2147483647(int型の最大値)を入力させる
			pe = "2147483647";
			entity.setPrice_end(Integer.parseInt(pe));
		}else if(ps.isEmpty() ) {
			ps = "0";
			entity.setPrice_start(Integer.parseInt(ps));
			entity.setPrice_end(Integer.parseInt(pe));
		}else if(pe.isEmpty() ) {
			pe = "2147483647";
			entity.setPrice_start(Integer.parseInt(ps));
			entity.setPrice_end(Integer.parseInt(pe));
		}else if((pe).compareTo(ps) < 0) {
			attributes.addFlashAttribute("errorMessage10","入力値が不正です。");
		}else {
			entity.setPrice_start(Integer.parseInt(ps));
			entity.setPrice_end(Integer.parseInt(pe));
		}
		List<ProductEntity> products = searchProductService.searchResult(entity);
		attributes.addFlashAttribute("products",products);
		return "redirect:/search";//GETメソッドを呼び出す。検索データ表示
	}

	/*ページング機能
	　商品検索結果、次へボタン押下*/
	@RequestMapping(value="search",method=RequestMethod,POST)

	//商品検索画面に戻る
	@RequestMapping(value="/detail",method=RequestMethod.POST,params="return")
	//セッションが切れないときあります。userEntityのセッションが切れないように気を付けて
	public String back(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/search";//GETメソッドを呼び出す。
	}

	//商品詳細画面に遷移
	@RequestMapping(value="/detail",method=RequestMethod.POST,params="detail")
	public String toProductInfo(@ModelAttribute SearchProductInfoModel searchProductInfoModel, Model model) {

		//商品コードの一致する商品の詳細情報を取得
		ProductEntity product = searchProductService.findOneProduct(searchProductInfoModel.getProduct_id());
		/*データベースから取得した画像のデータを16進数から64進数に変換する
			   これによってサイトのパフォーマンスが向上する*/
		product.setBase64string(Base64.getEncoder().encodeToString(product.getImage()));
		model.addAttribute("product",product);

		//サイズのプルダウン
		List<String> size =Arrays.asList(product.getSize().split(","));
		model.addAttribute("size",size);

		//商品コードの一致する商品の口コミを取得
		List<ReviewEntity> review = searchProductService.getReview(searchProductInfoModel.getProduct_id());
		model.addAttribute("review",review);

		return "productInfo";//商品詳細画面遷移
	}

	//カートに商品を追加
	@RequestMapping(value="detail",method=RequestMethod.POST,params="addCart")
	public String addCart(@ModelAttribute ProductInfoModel productInfoModel, Model model,UserEntity userEntity) {
		//ログインしている場合
		if(userEntity.getUser_id() != null) {
			Product_CartEntity cart = new Product_CartEntity();
			//商品詳細画面に表示されている情報と入力し情報をエンティティにセット
			cart.setProduct_id(productInfoModel.getProduct_id());
			cart.setUser_id(userEntity.getUser_id());
			cart.setQuantity(Integer.parseInt(productInfoModel.getQuantity()));
			cart.setSize(productInfoModel.getSize());
			cart.setColor(productInfoModel.getColor());
			//カートに追加するメソッドを呼び出す
			searchProductService.insertCart(cart);

			return "detail";
		//ログインしていない場合
		}else {
			model.addAttribute("loginMessage","ログインしてください");
			return "detail";
		}

	}
}