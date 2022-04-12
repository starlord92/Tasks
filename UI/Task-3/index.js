var x=1;

var div=document.createElement("div");
div.className="container";
document.body.appendChild(div);

var h1=document.createElement("h1");
h1.innerHTML="List Of To Do Tasks:";
div.appendChild(h1);
var span=document.createElement("span");
h1.appendChild(span);
span.innerHTML=x;

var div1=document.createElement("div");
div1.className="add-elements";
div.appendChild(div1);

const input=document.createElement("input");
input.id="add";
input.placeholder="Title...";
div1.appendChild(input);

const btn=document.createElement("button");
btn.id="btn";
btn.innerHTML="Add Activity";


div1.appendChild(btn);

var div2=document.createElement("div");
div2.className="element-list";
div.appendChild(div2);

const list=document.createElement("ul");
list.id="list";
div2.appendChild(list);

var el=document.createElement("li");
el.tagName="li";
el.className="sum";
el.innerHTML="Break-Fast";
list.appendChild(el);








// const input = document.querySelector("#add");
// const  btn = document.querySelector("#btn");
// const list = document.querySelector("#list");
// var el = document.getElementsByTagName('li');


btn.addEventListener("click" ,function(){
    
    var txt = input.value;
    if(txt ==''){
        alert('you must write something');
    }else{
        li = document.createElement('li');
    li.innerHTML = txt;
    list.insertBefore(li,list.null);
    span.innerHTML=++x;
    input.value = '';
    
    }
});

list.addEventListener("click",function(ev){
    if(ev.target.tagName == 'LI'){
         ev.target.classList.toggle('check');
    }
});