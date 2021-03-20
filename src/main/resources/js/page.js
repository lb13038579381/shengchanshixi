	
	function selectSchoolBusList(param){
		var currentPage = document.getElementById("currentPage").innerText;
		var pages = document.getElementById("pages").innerText;
		var loc = document.getElementById("location").innerText;
		
		//alert(currentPage + "," + pages + "," + loc);
		currentPage = parseInt(currentPage);
		pages = parseInt(pages);
		//var current = 1;
		if('index' == param){
			if(currentPage == 1)
				return false;
			else
				currentPage = 1;//请求页数
		}else if('pre' == param) {//上一页
			
			if(currentPage > 1){
				currentPage --;
			}else 
				return false;
		}else if('next' == param){//下一页
			if(currentPage < pages){
				currentPage ++;
			}else 
				return false;
		}else if('last' == param){//尾页
				if(currentPage == pages){
					return false;
				}else 
					currentPage = pages;
		}else {
			var jumpPage = document.getElementById("jump").value;
			
			jumpPage = parseInt(jumpPage);
			if(jumpPage < 0 || jumpPage > pages){
				alert("亲，输入页码不符合规范，总页数为：" + pages + "页")
				return false;
			}else if(jumpPage != currentPage){
				currentPage = jumpPage;
			}
		}
		
		//window.location .href = "selectSchoolBusList?currentPage=" + currentPage + "&limit=" + 2;
		window.location .href = loc + "?currentPage=" + currentPage + "&limit=" + 10;
	}