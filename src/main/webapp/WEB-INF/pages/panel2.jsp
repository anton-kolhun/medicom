<div class="panel panel-primary">
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