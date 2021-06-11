async function displayString(){
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();
    const aboutmeContainer = document.getElementById('aboutme');
    aboutmeContainer.innerText = textFromResponse;
}