package jp.co.bow.ec.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.bow.ec.entity.Payment_MethodEntity;
import jp.co.bow.ec.entity.Shipping_AddressEntity;
import jp.co.bow.ec.entity.UserEntity;
import jp.co.bow.ec.entity.User_StoreEntity;
import jp.co.bow.ec.model.ListDataModel;
import jp.co.bow.ec.model.LoginModel;
import jp.co.bow.ec.model.PaymentMethodModel;
import jp.co.bow.ec.model.ShipAddressModel;
import jp.co.bow.ec.model.UserInfoModel;
import jp.co.bow.ec.model.UserModel;
import jp.co.bow.ec.service.UserService;

@Controller
@SessionAttributes({"userEntity","CartContents","user_StoreEntity"})//しっかりできるか不安
public class UserController {
	@Autowired
	UserService userService;

	@ModelAttribute("loginModel")
	public LoginModel setUpLoginForm() {
		return new LoginModel();
	}

	@ModelAttribute("userEntity")
	public UserEntity setUpUserEntity() {
		return new UserEntity();
	}

	@ModelAttribute("paymentMethodModel")
	public PaymentMethodModel setUpPaymentMethodForm() {
		return new PaymentMethodModel();
	}

	@ModelAttribute("shipAddressModel")
	public ShipAddressModel setUpShipAddressForm() {
		return new ShipAddressModel();
	}
	@ModelAttribute("userInfoModel")
	public UserInfoModel setUpUserInfoForm() {
		return new UserInfoModel();
	}
	@ModelAttribute("userModel")
	public UserModel setUpUserForm() {
		return new UserModel();
	}

	private List<ListDataModel> getNumberList(int start,int end){
		List<ListDataModel> numberList= new ArrayList<ListDataModel>();
		for(int i=start;i<=end;i++) {
			numberList.add(new ListDataModel(Integer.toString(i),Integer.toString(i)));
		}
		return numberList;
	}
	private List<ListDataModel> getMonthList(int start,int end){
		List<ListDataModel> monthList= new ArrayList<ListDataModel>();
		for(int i=start;i<=end;i++) {
			monthList.add(new ListDataModel(String.format("%02d", i),String.format("%02d", i)));
		}
		return monthList;
	}


	//トップ画面表示
	@RequestMapping(value="/top",method=RequestMethod.GET)
	public String toTop(@ModelAttribute UserEntity userEntity,Model model) {
		//セッション有無確認

//		if(userEntity.getUser_id() == null) {
//			userEntity.setNickname("ゲスト");
//		}
		return "top";
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin(Model model) {
		return"login";
	}

	//ログイン認証用メソッド
	@RequestMapping(value="/checkUser",method=RequestMethod.POST, params="login")//value="/checkUser"
	public String checkUser(@Validated @ModelAttribute LoginModel loginModel,BindingResult result,Model model) {

		if(result.hasErrors()) {
			return "login";
		}
		User_StoreEntity userStoreEntity=new User_StoreEntity();
		userStoreEntity.setPassword(loginModel.getPassword());
		userStoreEntity.setUser_id(loginModel.getUser_id());

		User_StoreEntity loginCheck = userService.loginCheck(userStoreEntity);

		if(null!=loginCheck) {//login確認
			if(loginCheck.getUser_id().equals(loginModel.getUser_id())&&loginCheck.getPassword().equals(loginModel.getPassword())) {
			int countCart = 0;
			UserEntity userEntity = new UserEntity();
			userService.setLoginTime(loginModel.getUser_id());
			userEntity = userService.getUserInfo(loginModel.getUser_id());

			/*purchaseProductService.findCartAll(loginModel.getUser_id());
			for(Product_CartEntity cart:purchaseProductService.findCartAll(loginModel.getUser_id()){
				countCart++;
			}
			 */
			//パーチェスプロダクトサービス完成後実装すること。

			model.addAttribute("userEntity",userEntity);
			//model.addAttribute("CartContents",countCart);
			return "top";
			}
			model.addAttribute("errorMessage","ユーザーIDまたはパスワードが間違っています。");
			return"login";
		}else {
			model.addAttribute("errorMessage","ユーザーIDまたはパスワードが間違っています。");
			return"login";
			}

	}

	@RequestMapping(value="/checkUser",method=RequestMethod.POST, params="cancel")
	public String cancel() {
		return"redirect:/top";//GETメソッドを呼び出す。
	}
	@RequestMapping(value="/registUserInfo",method=RequestMethod.POST,params="back")
	public String back(SessionStatus status) {
		status.setComplete();
		return "redirect:/registUser";
	}
	//新規登録画面の表示
	@RequestMapping(value="/registUser",method=RequestMethod.GET)
	public String toRegist() {
		return "registUser";
	}

	@RequestMapping(value="/registUser",method=RequestMethod.POST)
	public String registUser(@Validated @ModelAttribute UserModel userModel, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "registUser";
		}
		if(userModel.getPassword().equals(userModel.getPassword2()) && null == userService.checkUserId(userModel.getUser_id())){

			//nullの時登録可能
			User_StoreEntity user_StoreEntity= new User_StoreEntity();
			user_StoreEntity.setPassword(userModel.getPassword());
			user_StoreEntity.setUser_id(userModel.getUser_id());
			model.addAttribute("user_StoreEntity",user_StoreEntity);

		} else if(null != userService.checkUserId(userModel.getUser_id()) && userModel.getPassword().equals(userModel.getPassword2())){//UserIdが既に存在していた場合
			model.addAttribute("errorMessage1","ユーザーIDは既に登録されています。");
			return "registUser";

		} else if(!userModel.getPassword().equals(userModel.getPassword2()) && null == userService.checkUserId(userModel.getUser_id())){
			model.addAttribute("errorMessage2","確認用パスワードが間違っています。");
			return "registUser";
		} else {
			model.addAttribute("errorMessage1","ユーザーIDは既に登録されています。");
			model.addAttribute("errorMessage2","確認用パスワードが間違っています。");
			return "registUser";
		}
		return "registUserInfo";
	}

	@RequestMapping(value="/registUserInfo", method=RequestMethod.POST ,params="regist")
	public String registUserInfo(@Validated @ModelAttribute UserInfoModel userInfoModel,BindingResult result,@ModelAttribute User_StoreEntity userStoreEntity,
			 RedirectAttributes attributes,Model model){
		if(result.hasErrors()) {
			return "registUserInfo";
		}


		if(null == userService.checkEmail(userInfoModel.getEmail())) {
			UserEntity userEntity = new UserEntity();
			userEntity.setUser_id(userStoreEntity.getUser_id());
			userEntity.setAddress1(userInfoModel.getAddress1());
			userEntity.setAddress2(userInfoModel.getAddress2());

			String birth = userInfoModel.getBirthday();
			birth = birth.replace("-", "/");
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate birthday = LocalDate.parse(birth,format);
			userEntity.setBirthday(birthday);
			userEntity.setEmail(userInfoModel.getEmail());
			userEntity.setName(userInfoModel.getName());
			userEntity.setNickname(userInfoModel.getNickname());
			userEntity.setPhone_number(userInfoModel.getPhone_number());
			userEntity.setPostal_code(userInfoModel.getPostal_code());

			model.addAttribute("userEntity",userEntity);//sessionに登録
//			userService.createLoginTime(userStoreEntity);
//			userService.createUserInfo(userEntity);
//			userService.createUser(userStoreEntity);
			//クレカの月、年のリストを渡す処理↓


//			Calendar cal= Calendar.getInstance();
//			model.addAttribute("years",getNumberList(cal.get(Calendar.YEAR),cal.get(Calendar.YEAR)+10));
//			model.addAttribute("months",getMonthList(1,12));
			//

			return "confirm";
			//return "payMethod";//confirm画面に飛ばす。
		} else {
			model.addAttribute("errorMessage","そのEmailアドレスは登録されています");
			attributes.addFlashAttribute("userInfoModel",userInfoModel);

			return "registUserInfo";
		}

	}

	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public String confirmUserInfo(@ModelAttribute User_StoreEntity userStoreEntity,@ModelAttribute UserEntity userEntity,Model model) {

	userService.createLoginTime(userStoreEntity);
	userService.createUserInfo(userEntity);
	userService.createUser(userStoreEntity);

	Calendar cal= Calendar.getInstance();
	model.addAttribute("years",getNumberList(cal.get(Calendar.YEAR),cal.get(Calendar.YEAR)+10));
	model.addAttribute("months",getMonthList(1,12));
	return "payMethod";
	}

	@RequestMapping(value="/confirm",method=RequestMethod.POST, params="modify")
	public String modify() {
		return "registUserInfo";
	}

	@RequestMapping(value="/registCard", method=RequestMethod.POST,params="regist")
	public String registCard(@Validated @ModelAttribute PaymentMethodModel paymentMethodModel,BindingResult result, Model model,RedirectAttributes attributes) {
		if(result.hasErrors()) {
		Calendar cal= Calendar.getInstance();
		model.addAttribute("years",getNumberList(cal.get(Calendar.YEAR),cal.get(Calendar.YEAR)+10));
		model.addAttribute("months",getMonthList(1,12));

			return "payMethod";
		}
		if(null == userService.checkCard(paymentMethodModel.getCard_number())) {
			System.out.println(paymentMethodModel.getExpiration_year());
			System.out.println(paymentMethodModel.getExpiration_month());
			Payment_MethodEntity payment_MethodEntity = new Payment_MethodEntity();
			payment_MethodEntity.setCard_holder_name(paymentMethodModel.getCard_holder_name());
			payment_MethodEntity.setCard_number(paymentMethodModel.getCard_number());
			payment_MethodEntity.setPayment_method(paymentMethodModel.getPayment_method());
			payment_MethodEntity.setUser_id(paymentMethodModel.getUser_id());
			String expirationDate =paymentMethodModel.getExpiration_year() + "/" + paymentMethodModel.getExpiration_month()+"/01";
			System.out.println(expirationDate);
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate exDate = LocalDate.parse(expirationDate,format);
			payment_MethodEntity.setExpiration_date(exDate);
			userService.createCard(payment_MethodEntity);
			return "shipAddress";
		} else {
			model.addAttribute("errorMessage", "そのカードは登録されています。");
			attributes.addFlashAttribute("paymentMethodModel",paymentMethodModel);
			Calendar cal= Calendar.getInstance();
			model.addAttribute("years",getNumberList(cal.get(Calendar.YEAR),cal.get(Calendar.YEAR)+10));
			model.addAttribute("months",getMonthList(1,12));
			return "payMethod";
		}
	}

	@RequestMapping(value="/registCard", method=RequestMethod.POST,params="skip")
	public String notRegistCard(Model model) {
		return "shipAddress";
	}

	@RequestMapping(value="/registShip", method=RequestMethod.POST, params="regist")
	public String registShip(@Validated @ModelAttribute ShipAddressModel shipAddressModel,BindingResult result,SessionStatus status,RedirectAttributes attributes, Model model) {
		Shipping_AddressEntity shipping_AddressEntity = new Shipping_AddressEntity();
		if(result.hasErrors()) {
			return "shipAddress";
		}
		shipping_AddressEntity.setAddress1(shipAddressModel.getAddress1());
		shipping_AddressEntity.setAddress2(shipAddressModel.getAddress2());
		shipping_AddressEntity.setPhone_number(shipAddressModel.getPhone_number());
		shipping_AddressEntity.setPostal_code(shipAddressModel.getPostal_code());
		shipping_AddressEntity.setShipping_address_name(shipAddressModel.getShipping_address_name());
		shipping_AddressEntity.setUser_id(shipAddressModel.getUser_id());
		userService.createShip(shipping_AddressEntity);
		attributes.addFlashAttribute("finishMessage","会員登録が完了しました。ログインしてください。");
		status.setComplete();
		return "redirect:/top";
	}
	@RequestMapping(value="/registShip", method=RequestMethod.POST, params="skip")
	public String notRegistShip(SessionStatus status,RedirectAttributes attributes,Model model) {
		attributes.addFlashAttribute("finishMessage","会員登録が完了しました。ログインしてください。");
		status.setComplete();
		return "redirect:/top";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/top";
	}
}
