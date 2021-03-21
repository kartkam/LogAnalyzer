<h1>Log entries</h1>

	<div style="overflow-x: scroll;">
		<table id="logsTable" class="display" style="width:100%;">
	      
	       <!-- Header Table -->
	       <thead>
	            <tr>
	            	<th></th>
	                <th>Generated At</th>
					<th>IP Address</th>
	                <th>User Agent</th>
	                <th>Status Code</th>
	                <th>Request Type</th>
	                <th>API</th>
	                <th>User Name</th>
	                <th>User Login</th>
	                <th>Enterprise Id</th>
	                <th>Enterprise Name</th>
	            </tr>
	        </thead>
	        
	    </table>
    </div>
    
<script>

var logsTable;

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
	
	//get log entries data
	logsTable = $('#logsTable').DataTable( {
        "processing": true,
        "serverSide": true,
        "pageLength": 10,
        "ajax": {
            "url": "/logs/paginated",
            "data": function ( data ) {
			 //process data before sent to server.
         }},
        "columns": [
        	{
                "className":      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": ''
            },
             { "data": "generatedAt"  },
             { "data": "ipAddress"  },
             { "data": "userAgent"  },
             { "data": "statusCode"  },
             { "data": "requestType"  },
             { "data": "api"  },
             { "data": "userName"  },
             { "data": "userLogin"  },
             { "data": "enterpriseId"  },
             { "data": "enterpriseName"  }
             
             
         ]    
	});
	
	
    // Setup - add a text input to each footer cell for filter
    $('#logsTable thead tr').clone(true).appendTo( '#logsTable thead' );
    $('#logsTable thead tr:eq(1) th').each( function (i) {
    	if(i!=0){
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	 
	        $( 'input', this ).on( 'keyup change', function (event) {
	            if ( logsTable.column(i).search() !== this.value ) {
	            	logsTable
	                    .column(i)
	                    .search( this.value )
	                    .draw();
	            }
	        } );
    	}
    } );
	
	
    $('#logsTable').dataTable().fnSetFilteringEnterPress();
	
    
 // Add event listener for opening and closing details
    $('#logsTable tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = logsTable.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child("<p>"+row.data().logString+"</p>").show();
            tr.addClass('shown');
        }
    } );
	
});
</script>