(function($, root, undefined) {
	$(function() {
		'use strict';

		$(document).on('change', '.task-status', function(e) {
			var taskId = $(this).data('task-id');
			var selectedStatus = $(this).val();

			var data = {
				taskId : taskId,
				selectedStatus : selectedStatus
			};

			$.post("changeStatus", data).done(function(result) {
				console.log(result);
			});
		});

	});
})(jQuery, this);