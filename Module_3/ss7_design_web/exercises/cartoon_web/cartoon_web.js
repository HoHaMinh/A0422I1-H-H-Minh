const _417 = document.getElementById('_417');
const _418 = document.getElementById('_418');
const _419 = document.getElementById('_419');
const menu = document.getElementById('menu');
const content = document.getElementById('content');

function hideAll() {
    _417.style.display = "none";
    _418.style.display = "none";
    _419.style.display = "none";
}

function hideMenuShowContent() {
    menu.style.display = 'none';
    content.style.display = 'block';
}

function show(id) {
    hideAll();
    if (window.innerWidth <= 740) {
        hideMenuShowContent();
    }
    switch (id) {
        case '417':
            _417.style.display = "block";
            break;
        case '418':
            _418.style.display = "block";
            break;
        case '419':
            _419.style.display = "block";
    }
}