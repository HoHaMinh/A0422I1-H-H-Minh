const baby_story = document.getElementById('baby');
const birds_story = document.getElementById('birds');
const cat_story = document.getElementById('cat');
const bear_story = document.getElementById('bear');

function hideAll() {
    baby_story.style.display = "none";
    birds_story.style.display = "none";
    cat_story.style.display = "none";
    bear_story.style.display = "none";
}

function show(id) {
    hideAll();
    switch (id) {
        case '1':
            baby_story.style.display = "block";
            break;
        case '2':
            birds_story.style.display = "block";
            break;
        case '3':
            cat_story.style.display = "block";
            break;
        case '4':
            bear_story.style.display = "block";
    }
}