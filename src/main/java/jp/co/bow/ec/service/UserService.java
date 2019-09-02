package jp.co.bow.ec.service;

import org.springframework.stereotype.Service;

import jp.co.bow.ec.entity.Login_HistoryEntity;
import jp.co.bow.ec.entity.Payment_MethodEntity;
import jp.co.bow.ec.entity.Shipping_AddressEntity;
import jp.co.bow.ec.entity.UserEntity;
import jp.co.bow.ec.entity.User_StoreEntity;
@Service
public interface UserService {
	//ログイン時のIDとパスチェック
	User_StoreEntity loginCheck(User_StoreEntity entity);

	//ユーザーIDが一致するかの確認
	User_StoreEntity checkUserId(String user_id);

	//ユーザー情報を持ってくる(userテーブルのすべて＋ログイン履歴）
	UserEntity getUserInfo(String user_id);

	//Email重複確認
	UserEntity checkEmail(String email);

	//Card番号の重複管理
	Payment_MethodEntity checkCard(String card_number);

	//ユーザー作成
	User_StoreEntity createUser(User_StoreEntity entity);

	//パスワード更新用
	User_StoreEntity updateUser(String user_id);

	//ユーザー情報の一件検索
	User_StoreEntity findOneUser(String user_id);

	//ユーザー情報設定（初期設定）
	UserEntity createUserInfo(UserEntity entity);

	//ユーザー情報更新
	UserEntity updateUserInfo(String user_id);

	//アカウント情報の一件検索
	UserEntity findOneUserInfo(String user_id);

	//新規カード情報設定
	Payment_MethodEntity createCard(Payment_MethodEntity entity);

	//カード情報更新
	Payment_MethodEntity updateCard(int payment_no);

	//カード情報削除
	void deleteCard(int payment_no);

	//カード情報の一件検索
	Payment_MethodEntity findOneCard(int payment_no);

	//届け先情報の一件検索
	Shipping_AddressEntity findOneShip(int shipping_address_no);

	//新規届け先設定
	Shipping_AddressEntity createShip(Shipping_AddressEntity entity);

	//届け先情報更新
	Shipping_AddressEntity updateShip(int shipping_address_no);

	//届け先情報削除
	void deleteShip(int shipping_address_no);

	//ログイン時刻設定
	Login_HistoryEntity setLoginTime(String user_id);

	//ログイン時刻の一件検索
	Login_HistoryEntity findOneTime(String user_id);

	//新規登録時のログイン時刻設定
	User_StoreEntity createLoginTime(User_StoreEntity entity);

}
