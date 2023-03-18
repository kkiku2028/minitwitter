$(function() {
	$(".logoutbutton").on("click", function(){
		if(!confirm("ログアウトしてよろしいですか?")) {
			return false;
		} else {
			return true;
		}
	});
	
});