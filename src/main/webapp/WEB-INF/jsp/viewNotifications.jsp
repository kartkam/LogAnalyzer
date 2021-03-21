<h1>Notification entries</h1>

	<div style="overflow-x: scroll;">
		<table id="notificationsTable" class="display" style="width:100%;">
	      
	       <!-- Header Table -->
	       <thead>
	            <tr>
	                <th>Generated At</th>
					<th>File Name</th>
	                <th>Message</th>
	                <th>Message type</th>
	                
	            </tr>
	        </thead>
	        
	    </table>
    </div>
    
<script>

var notificationsTable;

$(document).ready( function () {
	
	jQuery.fn.dataTableExt.oApi.fnSetFilteringEnterPress = function(oSettings) {
		var _that = this;

		this.each(function(i) {
			$.fn.dataTableExt.iApiIndex = i;
			var anControl = $('input', _that.fnSettings().aanFeatures.f);

			anControl.unbind('keyup search input').bind(
					'keyup search input',
					function(e) {
						if (anControl.val().length == "" || anControl.val().length > 2) {
							_that.fnFilter(anControl.val());
						}
					});
			return this;
		});
		return this;
	};
	
	//get notification entries data
	notificationsTable = $('#notificationsTable').DataTable( {
        "processing": true,
        "serverSide": true,
        "pageLength": 10,
        "ajax": {
            "url": "/notifications/paginated",
            "data": function ( data ) {
			 //process data before sent to server.
         }},
        "columns": [
             { "data": "dateTimeOfOccurrence"  },
             { "data": "fileName"  },
             { "data": "messageString"  },
             { "data": "messageType"  }
             
         ]    
	});
	
	
    // Setup - add a text input to each footer cell
    $('#notificationsTable thead tr').clone(true).appendTo( '#notificationsTable thead' );
    $('#notificationsTable thead tr:eq(1) th').each( function (i) {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
 
        $( 'input', this ).on( 'keyup change', function (event) {
            if ( notificationsTable.column(i).search() !== this.value ) {
            	notificationsTable
                    .column(i)
                    .search( this.value )
                    .draw();
            }
        } );
    } );
	
	
    $('#notificationsTable').dataTable().fnSetFilteringEnterPress();
	
	
});
</script>