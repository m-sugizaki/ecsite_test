package jp.co.bow.ec.repository;

import jp.co.bow.ec.entity.Login_HistoryEntity;
import jp.co.bow.ec.entity.Payment_MethodEntity;
import jp.co.bow.ec.entity.Shipping_AddressEntity;
import jp.co.bow.ec.entity.UserEntity;
import jp.co.bow.ec.entity.User_StoreEntity;


//テストですよーーーーーーーーーーーーーーーーーーーーー
public interface UserRepository {
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
	void createUser(User_StoreEntity entity);

	//パスワード更新用
	boolean updateUser(User_StoreEntity entity);

	//新規登録時のログイン時刻設定
	void createLoginTime(User_StoreEntity entity);

	//ログイン時刻設定
	boolean setLoginTime(Login_HistoryEntity entity);

	//ユーザー情報設定（初期設定）
	void createUserInfo(UserEntity entity);

	//ユーザー情報更新
	boolean updateUserInfo(UserEntity entity);

	//新規カード情報設定
	void createCard(Payment_MethodEntity entity);

	//カード情報の一件検索
	Payment_MethodEntity findOneCard(int payment_no);

	//届け先情報の一件検索
	Shipping_AddressEntity findOneShip(int shipping_address_no);

	//カード情報更新
	boolean updateCard(Payment_MethodEntity entity);

	//カード情報削除
	void deleteCard(Payment_MethodEntity entity);

	//ユーザー情報の一件検索
	User_StoreEntity findOneUser(String user_id);

	//アカウント情報の一件検索
	UserEntity findOneUserInfo(String user_id);

	//ログイン時刻の一件検索
	Login_HistoryEntity findOneTime(String user_id);

	//新規届け先設定
	void createShip(Shipping_AddressEntity entity);

	//届け先情報更新
	boolean updateShip(Shipping_AddressEntity entity);

	//届け先情報削除
	void deleteShip(Shipping_AddressEntity entity);
}
