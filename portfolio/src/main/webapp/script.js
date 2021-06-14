async function displayString(){
    const responseFromServer = await fetch('/hello');   
    const response = await responseFromServer.json(); 
    console.log(response);
    const myList = document.getElementById('mydetails'); 
    for (i =0; i < response.message.length; i ++){
        myList.appendChild(addItem(response.message[i]));
    }  
}

function addItem(message) {
  const liElement = document.createElement('li');
  liElement.innerText = message;
  return liElement;
}
