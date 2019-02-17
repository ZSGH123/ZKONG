$(function() {
	/*1.选中单击去右边*/
	$("#card_left").click(function() {
		$("#card_left").css({
			"border-bottom": "2px orange solid",

		});

		$("#card_right").css({
			"border-bottom": "none",

		});

	});

	$("#card_right").click(function() {
		$("#card_right").css({
			"border-bottom": "2px orange solid",

		});

		$("#card_left").css({
			"border-bottom": "none",

		});

	});
});