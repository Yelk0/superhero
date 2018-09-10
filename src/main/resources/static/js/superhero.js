
var allies = 0;
$("#more").click(function(event){
    event.preventDefault();
    $("#allies").append('<input name="allies[' + allies + ']" type="text" class="form-control mb-3" placeholder="Ally" required/>');
    allies++;
});