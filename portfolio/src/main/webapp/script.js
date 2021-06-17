async function displayString(){
    const responseFromServer = await fetch('/hello');   
    const response = await responseFromServer.json(); 
    console.log(response);
    const myList = document.getElementById('mydetails'); 
    for (i =0; i < response.message.length; i ++){
        myList.appendChild(addItem(response.message[i]));
    }  
}

async function getEmails(){
    const responseFromServer = await fetch('/list-tasks');   
    const response = await responseFromServer.json();     
    const myEmails = document.getElementById('myemails'); 
    for (i =0; i < response.length; i ++){
        myEmails.appendChild(addItem(response[i].emailaddress + " " + response[i].emailmessage));
    }     
}

function addItem(message) {
  const liElement = document.createElement('li');
  liElement.innerText = message;
  return liElement;
}
