<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Javascript - Extending forms</title>
    <link rel="up" href="contents.html"/>
    <link rel="intro" href="intro.html"/>
    <script type="text/javascript">
        <!--

        var counter = 0;

        function init() {
            document.getElementById('moreFields').onclick = moreFields;
            moreFields();
        }

        function moreFields() {
            counter++;
            var newFields = document.getElementById('readroot').cloneNode(true);
            newFields.id = '';
            newFields.style.display = 'block';
            var newField = newFields.childNodes;
            for (var i = 0; i < newField.length; i++) {
                var theName = newField[i].name;
                if (theName)
                    newField[i].name = theName + counter;
            }
            var insertHere = document.getElementById('writeroot');
            insertHere.parentNode.insertBefore(newFields, insertHere);
        }

        // -->
    </script>
</head>

<body>

<h2>Extending forms</h2>

<div id="header"></div>

<div class="floater">
    <p>See section 8E of <a href="/book/">the book</a> for cloning elements.</p>
    <p>Explorer 6 Windows hase serious trouble with radio buttons. Despite different names they see
        all generated radio buttons as one array, so the user can only select one radio button in all the
        copies.</p>
</div>

<p class="intro">On this page I treat a very simple W3C DOM script. It serves to explain why
    I think the W3C DOM will allow us to see interaction design in a radically new way.</p>

<h3>The idea</h3>

<p>Suppose you have an online CD ranking tool. You want your users to review as many CD's as
    they like. However, how do you know how many CD's an average user wants to review? How many
    form fields should you add to the page?</p>

<p>Before the W3C DOM this was quite a problem. Suppose you add form fields for 7 CD's. Some
    users will review only one CD and don't need the rest of the form (it might even frighten them).
    Other users might want to add their entire CD collection of hundreds of titles to your database
    and have to submit the form dozens of times. This is quite annoying.</p>

<p><em>Only</em> using the W3C DOM you can allow your users to generate as many form fields as they need. This effect
    is impossible to mimic with any previous JavaScript technique.</p>

<h3>Example</h3>

<p>Which CD's did you listen to recently?</p>

<div id="readroot" style="display: none">

    <input type="button" value="Remove review"
           onclick="this.parentNode.parentNode.removeChild(this.parentNode);"/><br/><br/>

    <input name="cd" value="title"/>

    <select name="rankingsel">
        <option>Rating</option>
        <option value="excellent">Excellent</option>
        <option value="good">Good</option>
        <option value="ok">OK</option>
        <option value="poor">Poor</option>
        <option value="bad">Bad</option>
    </select><br/><br/>

    <textarea rows="5" cols="20" name="review">Short review</textarea>
    <br/>Radio buttons included to test them in Explorer:<br/>
    <input type="radio" name="something" value="test1"/>Test 1<br/>
    <input type="radio" name="something" value="test2"/>Test 2

</div>

<form method="post" action="/cgi-bin/show_params.cgi">

    <span id="writeroot"></span>

    <input type="button" id="moreFields" value="Give me more fields!"/>
    <input type="submit" value="Send form"/>

</form>

<p>When you hit 'Send form' the form is sent to a script that lists the parameters it has
    received. This is to check whether the generated fields are really sent to the server. Unfortunately
    it turns out that Explorer Mac and Safari don't send any fields to the server.</p>

<h4>Problems in Explorer</h4>

<p>Unfortunately there are two serious problems in Explorer Windows:</p>

<p>First of all it sees all generated radio buttons as belonging to one single array, even if they have different
    <code>name</code>s. Thus the user can select only one radio button in all generated fields. Basically this means
    that
    you <em>cannot use radio buttons at all</em> in generated forms.</p>

<p>A reader said that generating radio buttons through <code>innerHTML</code> works fine. If you must use
    radio buttons, you might try this approach.</p>

<p>Secondly the generated form fields are unreachable by a traditional <code>document.forms</code> call: Explorer simply
    doesn't enter them in the arrays. This can be worked around by giving the form field an ID and then using <code>getElementById()</code>.
</p>

<h3>Explanation</h3>

<p>The HTML of the form is:</p>

<pre>
&lt;div id="readroot" style="display: none"&gt;

	&lt;input type="button" value="Remove review"
		onclick="this.parentNode.parentNode.removeChild(this.parentNode);" /&gt;&lt;br /&gt;&lt;br /&gt;

	&lt;input name="cd" value="title" /&gt;

	&lt;select name="rankingsel"&gt;
		&lt;option&gt;Rating&lt;/option&gt;
		&lt;option value="excellent"&gt;Excellent&lt;/option&gt;
		&lt;option value="good"&gt;Good&lt;/option&gt;
		&lt;option value="ok"&gt;OK&lt;/option&gt;
		&lt;option value="poor"&gt;Poor&lt;/option&gt;
		&lt;option value="bad"&gt;Bad&lt;/option&gt;
	&lt;/select&gt;&lt;br /&gt;&lt;br /&gt;

	&lt;textarea rows="5" cols="20" name="review"&gt;Short review&lt;/textarea&gt;
	&lt;br /&gt;Radio buttons included to test them in Explorer:&lt;br /&gt;
	&lt;input type="radio" name="something" value="test1" /&gt;Test 1&lt;br /&gt;
	&lt;input type="radio" name="something" value="test2" /&gt;Test 2

&lt;/div&gt;

&lt;form method="post" action="/cgi-bin/show_params.cgi"&gt;

	&lt;span id="writeroot"&gt;&lt;/span&gt;

	&lt;input type="button" id="moreFields" value="Give me more fields!" /&gt;
	&lt;input type="submit" value="Send form" /&gt;

&lt;/form&gt;

</pre>

<p>The actual form fields are in a DIV with id readroot and <code>display: none</code>.
    This DIV is a template that should not be changed by the user. When the user wants more
    fields we clone the DIV and append this clone to the form. We do this once onLoad, so that
    the user sees one set of form fields when entering the page.</p>

<p>The DIV is outside the actual FORM so that the template fields aren't sent to the server
    when the form is submitted.</p>

<p>The span with id writeroot serves as a marker. The new sets of form fields
    should be inserted just before it.</p>

<h4>Adding form fields</h4>

<p>This script adds sets of form fields when necessary:</p>

<pre>
var counter = 0;

function moreFields() {
	counter++;
	var newFields = document.getElementById('readroot').cloneNode(true);
	newFields.id = '';
	newFields.style.display = 'block';
	var newField = newFields.childNodes;
	for (var i=0;i&lt;newField.length;i++) {
		var theName = newField[i].name
		if (theName)
			newField[i].name = theName + counter;
	}
	var insertHere = document.getElementById('writeroot');
	insertHere.parentNode.insertBefore(newFields,insertHere);
}

window.onload = moreFields;
</pre>

<p>First of all we need a <code>counter</code>, because all sets of form fields should get
    unique names. We do this by appending <code>counter</code> to the names in the template. Initialize
    <code>counter</code>:</p>

<pre>
var counter = 0;
</pre>

<p>Then for the actual function. Start by increasing <code>counter</code> by 1.</p>

<pre>
function moreFields() {
	counter++;
</pre>

<p>Then we clone our template, remove its <code>id</code> and set its <code>display</code>
    to <code>block</code>. The id 'readroot' should remain unique in the document, and the clone
    of the template should be visible to the user.</p>

<pre>
	var newFields = document.getElementById('readroot').cloneNode(true);
	newFields.id = '';
	newFields.style.display = 'block';
</pre>

<p>We go through the child nodes of the clone</p>

<pre>
	var newField = newFields.childNodes;
	for (var i=0;i&lt;newField.length;i++) {
</pre>

<p>Whenever a child node has a <code>name</code> we append <code>counter</code> to it. Thus
    the names of all form fields remain unique.</p>

<pre>
		var theName = newField[i].name
		if (theName)
			newField[i].name = theName + counter;
	}
</pre>

<p>Now the clone is ready to be inserted into the document. We insert it just before the
    span with id="writeroot".</p>

<pre>
	var insertHere = document.getElementById('writeroot');
	insertHere.parentNode.insertBefore(newFields,insertHere);
}
</pre>

<p>Finally we execute this function once onLoad so that the user will initially see one set
    of form fields.</p>

<pre>
window.onload = moreFields;
</pre>

<h4>Removing form fields</h4>

<p>Each clone of the template contains a 'Remove review' button:</p>

<pre>
	&lt;input type="button" value="Remove review"
		onclick="this.parentNode.parentNode.removeChild(this.parentNode);" /&gt;&lt;br /&gt;&lt;br /&gt;
</pre>

<p>Clicking on it causes the button to remove its parent node (the DIV) from its own parent
    node (the FORM). Thus one set of form fields disappears entirely, never to return.</p>

<div id="footer"><a href="/home.html">Home</a> <a href="/sitemap.html">Sitemap</a>
    <p class="smaller" id="validation">Valid XHTML 1.0</p>
</div>

</body>
</html>
