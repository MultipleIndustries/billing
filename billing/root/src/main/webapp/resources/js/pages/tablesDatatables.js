/*
 *  Document   : tablesDatatables.js
 *  Author     : pixelcave
 *  Description: Custom javascript code used in Tables Datatables page
 */

var TablesDatatables = function() {

	 return {
	        init: function(actionCol) {
	            /* Initialize Bootstrap Datatables Integration */
	            App.datatables();

	            /* Initialize Datatables */
	            $('.datatable').dataTable({
	            	 "aoColumnDefs": [ { "bSortable": false,"bSearchable": true, "aTargets": [actionCol ] } ],
	                "iDisplayLength": 10,
	                "aLengthMenu": [[10, 20, 30, -1], [10, 20, 30, "All"]]
	            });

	            /* Add Bootstrap classes to select and input elements added by datatables above the table */
	            $('.dataTables_filter input').addClass('form-control').attr('placeholder', 'Search');
	            $('.dataTables_length select').addClass('form-control');
	        }
	    };
	}();