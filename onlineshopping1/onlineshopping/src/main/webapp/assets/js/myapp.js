$(function(){
	
	// solving the active menu problem
	
	switch(menu){
		
	case  'About Us' :
		$('#about').addClass('active');
		break;
		
	case  'Contact Us' :
		$('#contact').addClass('active');
		break;
		
	case  'All Products' :
		$('#listOfProducts').addClass('active');
		break;
		
	default :
		if(menu == "Home") break
		$('#listOfProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
	
	// code for jquery data table
	// create dataset
	
	var products = [
					['1','ABC'],
					['2','XYZ'],
					['3','AJF'],
					['4','UYC'],
					['5','DFC'],
					['6','YDE'],
					['7','XET']
	];
					
	var $table = $('#proudctListTable');
	
	// eecute below code only where we have this table
	if($table.length){
		$table.DataTable({
			lengthMenu : [[3,5,10,-1],['3 Record','5 Record','10 Record','All']],
			data : products
		});
	}
});