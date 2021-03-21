
<h1>Log File uploader</h1>

<div style="overflow-x: scroll;">
	<form id="form" method="post" action="/upload">
		<div id="uploader"></div>
		<br />
	</form>
</div>

<a href="main" id="refreshQueue" class="plupload_button ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-primary" role="button" aria-disabled="false">
	<span class="ui-button-icon-primary ui-icon ui-icon-circle-arrow-e"></span>
	<span class="ui-button-text">Refresh queue</span>
</a>

<script type="text/javascript">
	// Initialize the widget when the DOM is ready
	$(function() {
		$("#uploader").plupload({
			// General settings
			runtimes : 'html5,html4',
			url : '/upload',

			// User can upload no more then 20 files in one go (sets multiple_queues to false)
			max_file_count : 5,

			chunk_size : '1mb',

			// Resize images on clientside if we can
			resize : {
				width : 200,
				height : 200,
				quality : 90,
				crop : true
			// crop to exact dimensions
			},

			filters : {
				// Maximum file size
				max_file_size : '6000mb',
				// Specify what files to browse for
				mime_types : [ {
					title : "Text files",
					extensions : "txt"
				}
				
				]
			},

			// Rename files by clicking on their titles
			rename : true,

			// Sort files
			sortable : true,

			// Enable ability to drag'n'drop files onto the widget (currently only HTML5 supports that)
			dragdrop : true,

			// Views to activate
			views : {
				list : true,
				thumbs : true, // Show thumbs
				active : 'thumbs'
			}
		});

		// Handle the case when form was submitted before uploading has finished
		$('#form').submit(function(e) {
			// Files in queue upload them first
			if ($('#uploader').plupload('getFiles').length > 0) {

				// When all files are uploaded submit form
				$('#uploader').on('complete', function() {
					debugger;
					$('#form')[0].submit();
				});

				$('#uploader').plupload('start');
			} else {
				alert("You must have at least one file in the queue.");
			}
			return false;
		});
		
		
	});
</script>
