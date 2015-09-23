$(document).ready(

	function(){
		console.log("ready");
		
		var myData = {name:"testName"};
		var menu = $("#menu");
		var content = $("#content");
		
		menu.children("#toSubscribe").click(function() {
			$.ajax({
				url: "http://localhost:8080/subscribe",
				method: "GET",
				success: function(data){
					console.log(data);
					content.html(data);
				}
			});
		});
		
		/*$.ajax({
			url: "http://localhost:8080/new_article",
			method: "POST",
			data: myData,
			dataType: "json",
			success: function(data){
				console.log(data);
			}
		});*/
	}	
);