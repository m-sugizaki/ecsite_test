$(function(){

	var menu = $('#slide_menu'), // スライドインするメニューを指定
	menuBtn = $('#button'), // メニューボタンを指定
	body = $(document.body),
	menuWidth = menu.outerWidth();

	// メニューボタンをクリックした時の動き
	menuBtn.on('click', function(){
		// body に open クラスを付与する
		body.toggleClass('open');

		if(body.hasClass('open')){
			// open クラスが body についていたらメニューをスライドインする
			body.animate({'left' : menuWidth }, 300);
			menu.animate({'left' : 0 }, 300);

		} else {
			// open クラスが body についていなかったらスライドアウトする
			menu.animate({'left' : -menuWidth }, 300);
			body.animate({'left' : 0 }, 300);
		}

	});
$(window).on('load scroll', function(){

		//スクロールするとfixedクラスを追加
	if(menuBtn.on('click')){
		$('nav').addClass('fix');
	}else if ($(window).scrollTop() > 0) {
			$('nav').addClass('fixed');
		} else {
			//0px以下だとfixedクラスを削除
			$('nav').removeClass('fix');
			$('nav').removeClass('fixed');
			}
	});
});




