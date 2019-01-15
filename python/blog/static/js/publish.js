$(function(){
	$('#btnPublishPost').click(function(){
		
		$.ajax({
			url: '/publish',
			data: $('form').serialize(),
			type: 'POST',
			success: function(response){
				console.log(response);
			},
			error: function(error){
				console.log(error);
			}
		});
	});
});
