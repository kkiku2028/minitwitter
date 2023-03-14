$(function() {
	console.log($(".delete"));
	$(".delete").on("click", function(){
		if(!confirm("トゥイートを削除してもよろしいですか?")) {
			return false;
		} else {
			return true;
		}
	});
	
});

//		if(!confirm('削除してよろしいですか?')){
//			return false;
//		} else {
//			
//		}
