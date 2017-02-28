//选项卡
	window.onload=function()
 {  var oUl=document.getElementById('ul1');
    var aLi=oUl.getElementsByTagName('li');
    var oDiv=document.getElementById('main');
    var aDiv=oDiv.getElementsByClassName('bi');
    for(var i=0;i<aLi.length;i++)
    {   aLi[i].index=i;//index为自定义属性
        aLi[i].onclick= function()
        {   
            for(var i=0;i<aLi.length;i++)
            {   
                aLi[i].className='';
                aDiv[i].style.display='none';
                
            }


            this.className='active';
            aDiv[this.index].style.display='block';
        };
    }
    
   
}