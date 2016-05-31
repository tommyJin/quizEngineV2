/**
 * Created by tommy on 2016/5/31.
 */
var div = "#questiontype";

function initType(){
    var type = $("#type").find("option:selected").text();
    $(div).empty();
    if(type=="True Or False"){
        TrueFalse();
    }else if(type=="Calculate Numeric"){

    }else if(type=="MultipleChoice"){

    }
}

function TrueFalse(){
    var id = $("#id").val();
    var qc_content = $("#qc_content").val();
    var true_content = "";
    var false_content = "";
    var answer = $("#qc_answer").val();
    if(id != null && id.length!=0 && qc_content!=null && qc_content.length!=0){
        var qc = $.parseJSON(qc_content);
        true_content = qc.true;
        false_content = qc.false;
    }
    var content =
            '<div class="am-g am-margin-top">'+
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">True</div>'+
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">'+
            '<input type="text" id="true" class="am-form-field" value="" />'+
            '</div></div>'+
            '<div class="am-g am-margin-top">'+
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">False</div>'+
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">'+
            '<input type="text" id="false" class="am-form-field" value="" />'+
            '</div></div>'+
            '<div class="am-g am-margin-top">'+
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">Right Answer</div>'+
            '<div class="am-u-sm-8 am-u-md-10">'+
            '<select  id="qc_answer" name="qc.answer" >'+
            '<option value="true">True</option>'+
            '<option value="false">False</option>'+
            '</select></div></div>'
        ;
    $(div).append(content);
    $("#qc_answer").val(answer);
    $("#true").val(true_content);
    $("#false").val(false_content);
}

function collect(){
    var type = $("#type").find("option:selected").text();
    if(type=="True Or False"){
        var true_content = $("#true").val();
        var false_content = $("#false").val();
        var content = {};
        content.true = true_content;
        content.false = false_content;
        var content_str = JSON.stringify(content);
        $("#qc_content").val(content_str);
        var answer_str = $("#qc_answer").val()+"";
        $("#answer").val(answer_str);

    }else if(type=="Calculate Numeric"){

    }else if(type=="MultipleChoice"){

    }
}