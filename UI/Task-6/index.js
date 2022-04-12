
// var div=document.createElement("div");
// div.id='wrapper';
// document.body.appendChild(div)





function loadDoc() {
 
var table = document.createElement('table');
table.id = 'data_table';
document.body.appendChild(table)

var mr = document.createElement("tr");
table.appendChild(mr);

var th1 = document.createElement("th");
th1.innerHTML='FirstName';
mr.appendChild(th1)
var th2 = document.createElement("th");
th2.innerHTML='LastName';
mr.appendChild(th2)
var th3 = document.createElement("th");
th3.innerHTML='Email';
mr.appendChild(th3)

    
const xhttp = new XMLHttpRequest();

    xhttp.onload = function() {
    var obj	=JSON.parse(this.responseText);
    var x = obj.data;
    
    

   
    for (let i = 0; i <x.length; i++) { 

        let row = document.createElement("tr");
        row.setAttribute('id',i+1);
      
       
        
        let fn_row1 = document.createElement('td');
        fn_row1.setAttribute('id','fn_row'+row.id);
        fn_row1.innerHTML=x[i].first_name;
        row.appendChild(fn_row1)
        
        let ln_row1 = document.createElement('td');
        ln_row1.setAttribute('id','ln_row'+row.id);
        ln_row1.innerHTML=x[i].last_name;
        row.appendChild(ln_row1)
        
        let em_row1 = document.createElement('td');
        em_row1.setAttribute('id','em_row'+row.id);
        em_row1.innerText=x[i].email;
        row.appendChild(em_row1) 
        
        let s_row = document.createElement('td');
        

        let save= document.createElement('button');
        save.innerHTML="save";
        save.addEventListener('click',function(){
          var fn_val=document.getElementById("fn_text"+row.id).value;
          console.log(fn_val);
          var ln_val=document.getElementById("ln_text"+row.id).value;
          var em_val=document.getElementById("em_text"+row.id).value;
         
          document.getElementById("fn_row"+row.id).innerHTML=fn_val;
          document.getElementById("ln_row"+row.id).innerHTML=ln_val;
          document.getElementById("em_row"+row.id  ).innerHTML=em_val;

        });
        

        
        
        
        
        
        let bt_row = document.createElement('td');
        

        let btn = document.createElement('button');
        btn.id="edit_button1";
        btn.innerHTML="edit";
        btn.className="edit";
        btn.addEventListener('click',function(){

          // var z = JSON.stringify(i+1);
          // console.log(row.id);

             var firstname=document.getElementById("fn_row"+row.id);
             var lastname=document.getElementById("ln_row"+row.id);
             var email=document.getElementById("em_row"+row.id);
               
             var fn_data = firstname.innerHTML;
             var ln_data=lastname.innerHTML;
             var em_data=email.innerHTML;
               
            firstname.innerHTML="<input type='text' id='fn_text'"+row.id+" value=''"+fn_data+">";
             lastname.innerHTML="<input type='text' id='ln_text'"+row.id+" value=''"+ln_data+">";
             email.innerHTML="<input type='text' id='em_text' "+row.id+"  value=''"+em_data+">";
        });
      
        s_row.appendChild(save)
        row.appendChild(s_row)

        bt_row.appendChild(btn)
        row.appendChild(bt_row)
        table.appendChild(row)

       
        // btn.addEventListener('click',edit_row('1'));

        // table += "<tr><td>" +
        // x[i].first_name +
        // "</td><td>" +
        // x[i].last_name +
        // "</td><td>" + 
        // x[i].email + 
        // "</td><td>" + "<button id=edit_button1 class='edit'  onclick='edit_row()' > EDIT </button>" +"</td></tr>" ;
      }
    //   document.getElementById("data_table").innerHTML = table;
    }
        xhttp.open("GET", "https://reqres.in/api/users?page=1");
        xhttp.send();




      }













// function edit_row()
// {
//  document.getElementById("edit_button").style.display="none";
//  document.getElementById("save_button"+no).style.display="block";
	

// }

// function save_row(no)
// {
//  var name_val=document.getElementById("name_text"+no).value;
//  var country_val=document.getElementById("country_text"+no).value;
//  var age_val=document.getElementById("age_text"+no).value;

//  document.getElementById("name_row"+no).innerHTML=name_val;
//  document.getElementById("country_row"+no).innerHTML=country_val;
//  document.getElementById("age_row"+no).innerHTML=age_val;

//  document.getElementById("edit_button"+no).style.display="block";
//  document.getElementById("save_button"+no).style.display="none";
// }

// function delete_row(no)
// {
//  document.getElementById("row"+no+"").outerHTML="";
// }

// function add_row()
// {
//  var new_name=document.getElementById("new_name").value;
//  var new_country=document.getElementById("new_country").value;
//  var new_age=document.getElementById("new_age").value;
	
//  var table=document.getElementById("data_table");
//  var table_len=(table.rows.length)-1;
//  var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'><td id='name_row"+table_len+"'>"+new_name+"</td><td id='country_row"+table_len+"'>"+new_country+"</td><td id='age_row"+table_len+"'>"+new_age+"</td><td><input type='button' id='edit_button"+table_len+"' value='Edit' class='edit' onclick='edit_row("+table_len+")'> <input type='button' id='save_button"+table_len+"' value='Save' class='save' onclick='save_row("+table_len+")'> <input type='button' value='Delete' class='delete' onclick='delete_row("+table_len+")'></td></tr>";

//  document.getElementById("new_name").value="";
//  document.getElementById("new_country").value="";
//  document.getElementById("new_age").value="";
// }