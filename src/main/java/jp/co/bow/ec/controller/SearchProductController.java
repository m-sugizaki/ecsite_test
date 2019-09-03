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
import jp.co.bow.ec.model.ProductInfoModel;
import jp.co.bow.ec.model.SearchProductInfoModel;
import jp.co.bow.ec.service.SearchProductService;

@Controller
@SessionAttributes("products")
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
		//↓価格の条件指定がよく分からないので、お願いします。↓
		String ps= searchProductInfoModel.getPrice_start();//最低価格
		String pe= searchProductInfoModel.getPrice_end();//最大価格
		if(ps.isEmpty() && pe.isEmpty()) {
			//最低価格に何も入力しない場合、強制的に0を入力させる
			ps = "0";
			entity.setPrice_start(Integer.parseInt(ps));
			//最大価格に何も入力しない場合、強制的に2147483647(int型の最大値)を入力させる
			pe = "2147483647";
			entity.setPrice_end(Integer.parseInt(pe));
		}
		else if(ps.isEmpty() ) {
			ps = "0";
			entity.setPrice_start(Integer.parseInt(ps));
			entity.setPrice_end(Integer.parseInt(pe));
		}
		else if(pe.isEmpty() ) {
			pe = "2147483647";
			entity.setPrice_start(Integer.parseInt(ps));
			entity.setPrice_end(Integer.parseInt(pe));
		}
		else if((pe).compareTo(ps) < 0) {
			attributes.addFlashAttribute("errorMessage10","入力値が不正です。");
		}else {
			entity.setPrice_start(Integer.parseInt(ps));
			entity.setPrice_end(Integer.parseInt(pe));
		}
		List<ProductEntity> products = searchProductService.searchResult(entity);
		attributes.addFlashAttribute("products",products);
		return "redirect:/search";//GETメソッドを呼び出す。検索データ表示
	}

	//商品検索画面に戻る
	@RequestMapping(value="/detail",method=RequestMethod.POST,params="return")
	//セッションが切れないときあります。userEntityのセッションが切れないように気を付けて
	public String back(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/search";//GETメソッドを呼び出す。
	}
}