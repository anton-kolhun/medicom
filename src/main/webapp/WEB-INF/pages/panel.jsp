
<div class="panel panel-default">
    <div class="panel-body">
        Panel content
    </div>
    <div class="panel-footer">Panel footer</div>
    <ul class="nav nav-pills">
        3131
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Dropdown <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
                3131
            </ul>
        </li>
        3131
    </ul>

    <ul class="nav nav-tabs" role="tablist">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Profile</a></li>
        <li><a href="#">Messages</a></li>
    </ul>
</div>

<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu3">
    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Regular link</a></li>
    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Disabled link</a></li>
    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another link</a></li>
</ul>

<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">1.</div>
    <div class="btn-group">2</div>
    <div class="btn-group">3</div>
</div>

<div class="btn-group">
    <button type="button" class="btn btn-default">Left</button>
    <button type="button" class="btn btn-default">Middle</button>
    <button type="button" class="btn btn-default">Right</button>
</div>

<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
        Dropdown
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
    </ul>
</div>

<br/>
<br/>



<ul class="nav nav-pills">
    3131
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            Dropdown <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
           3131
        </ul>
    </li>
3131
</ul>

<div class="panel panel-info">
<ul  id="mainPanel" class="nav nav-tabs" role="tablist">
    <li class="active"><a onclick="setActive.call(this)" >Home</a></li>
    <li><a onclick="setActive.call(this)">Profile</a></li>
    <li><a onclick="setActive.call(this)">Messages</a></li>
</ul>
</div>

<script>
 function setActive() {
     $.each($("#mainPanel")[0].children, function(child) {
         console.log('childe');
         $(this).removeClass('active')
     });

     $(this.parentElement).addClass('active');

 }
</script>