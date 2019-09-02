package jp.co.bow.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bow.ec.entity.Login_HistoryEntity;
import jp.co.bow.ec.entity.Payment_MethodEntity;
import jp.co.bow.ec.entity.Shipping_AddressEntity;
import jp.co.bow.ec.entity.UserEntity;
import jp.co.bow.ec.entity.User_StoreEntity;
import jp.co.bow.ec.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	//ログイン時のIDとパスチェック
	@Override
	public User_StoreEntity loginCheck(User_StoreEntity entity) {
		return userRepository.loginCheck(entity);
	}

	//ユーザーIDが一致するかの確認
	@Override
	public User_StoreEntity checkUserId(String user_id) {
		return userRepository.checkUserId(user_id);
	}

	//ユーザー情報を持ってくる(userテーブルのすべて＋ログイン履歴）
	@Override
	public UserEntity getUserInfo(String userid) {
		return userRepository.getUserInfo(userid);
	}

	//Email重複確認
	@Override
	public UserEntity checkEmail(String email) {
		return userRepository.checkEmail(email);
	}

	//Card番号の重複管理
	@Override
	public Payment_MethodEntity checkCard(String card_number) {
		return userRepository.checkCard(card_number);
	}

	//ユーザー作成
	@Override
	public User_StoreEntity createUser(User_StoreEntity entity) {
		userRepository.createUser(entity);
		return entity;
	}

	//パスワード更新用
	@Override
	public User_StoreEntity updateUser(String user_id) {
		User_StoreEntity user = this.findOneUser(user_id);
		if(user != null) {
			userRepository.updateUser(user);
		}
		return user;
	}

	//ユーザー情報設定（初期設定）
	@Override
	public UserEntity createUserInfo(UserEntity entity) {
		userRepository.createUserInfo(entity);
		return entity;
	}

	//ユーザー情報更新
	@Override
	public UserEntity updateUserInfo(String user_id) {
		UserEntity userInfo = this.findOneUserInfo(user_id);
		if(userInfo != null) {
			userRepository.updateUserInfo(userInfo);
		}
		return userInfo;
	}

	//新規カード情報設定
	@Override
	public Payment_MethodEntity createCard(Payment_MethodEntity entity) {
		userRepository.createCard(entity);
		return entity;
	}

	//カード情報更新
	@Override
	public Payment_MethodEntity updateCard(int payment_no) {
		Payment_MethodEntity pay = this.findOneCard(payment_no);
		if(pay != null) {
			userRepository.updateCard(pay);
		}
		return pay;
	}

	//カード情報削除
	@Override
	public void deleteCard(int payment_no) {
		Payment_MethodEntity pay = this.findOneCard(payment_no);
		if(pay != null) {
			userRepository.deleteCard(pay);
		}
	}

	//新規届け先設定
	@Override
	public Shipping_AddressEntity createShip(Shipping_AddressEntity entity) {
		userRepository.createShip(entity);
		return entity;
	}

	//届け先情報更新
	@Override
	public Shipping_AddressEntity updateShip(int shipping_address_no) {
		Shipping_AddressEntity ship = this.findOneShip(shipping_address_no);
		if(ship != null) {
			userRepository.updateShip(ship);
		}
		return ship;
	}

	//届け先情報削除
	@Override
	public void deleteShip(int shipping_address_no) {
		Shipping_AddressEntity ship = this.findOneShip(shipping_address_no);
		if(ship != null) {
			userRepository.deleteShip(ship);
		}
	}

	//ログイン時刻設定
	@Override
	public Login_HistoryEntity setLoginTime(String user_id) {
		Login_HistoryEntity login = this.findOneTime(user_id);
		if(login != null) {
			userRepository.setLoginTime(login);
		}
		return login;
	}

	//カード情報の一件検索
	@Override
	public Payment_MethodEntity findOneCard(int payment_no) {
		return userRepository.findOneCard(payment_no);
	}

	//届け先情報の一件検索
	@Override
	public Shipping_AddressEntity findOneShip(int shipping_address_no) {
		return userRepository.findOneShip(shipping_address_no);
	}

	//ユーザー情報の一件検索
	@Override
	public User_StoreEntity findOneUser(String user_id) {
		return userRepository.findOneUser(user_id);
	}

	//アカウント情報の一件検索
	@Override
	public UserEntity findOneUserInfo(String user_id) {
		return userRepository.findOneUserInfo(user_id);
	}

	//ログイン時刻の一件検索
	@Override
	public Login_HistoryEntity findOneTime(String user_id) {
		return userRepository.findOneTime(user_id);
	}

	//新規登録時のログイン時刻設定
	@Override
	public User_StoreEntity createLoginTime(User_StoreEntity entity) {
		userRepository.createLoginTime(entity);
		return entity;
	}
}
