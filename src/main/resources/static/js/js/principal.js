const body = document.querySelector('body'),
sidebar = body.querySelector('nav'),
toggle = body.querySelector(".toggle"),
searchBtn = body.querySelector(".search-box"),
modeSwitch = body.querySelector(".toggle-switch"),
modeText = body.querySelector(".mode-text");


toggle.addEventListener("click" , () =>{
sidebar.classList.toggle("close");
})

searchBtn.addEventListener("click" , () =>{
sidebar.classList.remove("close");
})

modeSwitch.addEventListener("click" , () =>{
body.classList.toggle("dark");

if(body.classList.contains("dark")){
  modeText.innerText = "Light mode";
}else{
  modeText.innerText = "Dark mode";

}
});

const inventarioLink = document.getElementById('inventario-link');
const inventarioSublinks = document.getElementById('inventario-sublinks');

inventarioLink.addEventListener('click', function(event) {
    event.preventDefault(); // Evitar que el enlace cambie la página

    // Toggle para mostrar/ocultar los subenlaces
    inventarioSublinks.style.display = (inventarioSublinks.style.display === 'block') ? 'none' : 'block';
});
