/**
 * Created by Jude on 2/21/2016.
 */
var counter = 0;

function moreFields() {
    counter= counter+1;
    var newFields = document.getElementById('readroot').cloneNode(true);
    newFields.id = '';
    newFields.style.display = 'block';
    var newField = newFields.childNodes;
    for (var i = 0; i < newField.length; i++) {
        var theName = newField[i].name;
        if (theName){
            newField[i].name = theName + counter;}
    }
    var insertHere = document.getElementById('writeroot');
    insertHere.parentNode.insertBefore(newFields, insertHere);
}
window.onload = moreFields;
