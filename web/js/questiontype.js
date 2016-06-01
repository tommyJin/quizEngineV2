/**
 * Created by tommy on 2016/5/31.
 */
var div = "#questiontype";


function initType() {
    var type = $("#type").find("option:selected").text();
    //alert(type);
    $(div).empty();
    if (type == "True Or False") {
        trueFalse();
    } else if (type == "Calculate Numeric") {
        $(div).append(add_blank_button_html);
        //calculateNumeric();
        fillBlank();
    } else if (type == "MultipleChoice") {

    }else if (type == "Fill in the Blank") {
        $(div).append(add_blank_button_html);
        fillBlank();
    }

}

function fillBlank() {
    var id = $("#id").val();
    var answer = $("#answer").val();
    if (id != null && id.length != 0 && answer != null && answer.length != 0) {
        var a = $.parseJSON(answer);
        for (var i = 0; i < a.length; i++) {
            var tmp_id = a[i].id;
            var tmp_answer = a[i].answer;
            var tmp_feedback = a[i].feedback;
            if (tmp_id != null && tmp_id.length != 0) {
                addBlankContent(tmp_id, tmp_answer, tmp_feedback);
            }
        }
    }
}

function calculateNumeric() {

}


function trueFalse() {
    var id = $("#id").val();
    var answer = $("#answer").val();
    addTrueFalse(answer);
}

function collect() {
    var type = $("#type").find("option:selected").text();
    var answer_str = $("#answer").val() + "";
    $("#answer").val(answer_str);
    if (type == "True Or False") {
        var content = {};
        var answer = {};
        var true_content = $("#true_content").val();
        var false_content = $("#false_content").val();
        var feedback_true = $("#feedback-true").val();
        var feedback_false = $("#feedback-false").val();
        var right = $("#tf_answer").val();
        content.true_content = true_content;
        content.false_content = false_content;
        answer.true_content = true_content;
        answer.false_content = false_content;
        answer.feedback_true = feedback_true;
        answer.feedback_false = feedback_false;
        answer.right = right;
        var content_str = JSON.stringify(content);
        var answer_str = JSON.stringify(answer);
        $("#qc_content").val(content_str);
        $("#answer").val(answer_str);
    } else if (type == "MultipleChoice") {

    }else if (type == "Calculate Numeric" || type == "Fill in the Blank") {
        var content = [];
        var answer = [];

        var size = $("#blankIndex").val();
        for (var i=1; i<=size; i++){
            var tmp_c_id = "#content-blank_"+i;
            var tmp_f_id = "#feedback-blank_"+i;
            var tmp_c_div = $(tmp_c_id);
            var tmp_f_div = $(tmp_f_id);

            var tmp_a = {};
            var tmp_c = {};
            tmp_c.id = tmp_c_id.split("-")[1];
            tmp_a.id = tmp_c_id.split("-")[1];
            tmp_a.answer = tmp_c_div.val();
            tmp_a.feedback = tmp_f_div.val();
            answer.push(tmp_a);
            content.push(tmp_c);
        }

        var content_str = JSON.stringify(content);
        var answer_str = JSON.stringify(answer);
        $("#answer").val(answer_str);
        $("#qc_content").val(content_str);
    }
}

function addBlank() {
    var index = "blank_" + ( Number($("#blankIndex").val()) + 1);
    ke_content.insertHtml('<input type="button" id="' + index + '" value="' + index + '" disabled/>');
    addBlankContent(index, "", "");
    //addBlankContent1(index, "");
}

function addBlankContent(index, answer, feedback) {
    var content = '<div class="am-g am-margin-top">' +
        '<div class="am-u-sm-4 am-u-md-2 am-text-right">' + index + '</div>' +
        '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
        '<input type="text" id="content-' + index + '" class="am-form-field blank_content" value="' + answer + '" />' +
        '</div></div>';
    //content end here

    //add feedback editor
    content +=  '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">'+index+ ' Feedback</div>' +
        '<div class="am-u-sm-10">'+
        '<textarea id="feedback-' + index + '" class="am-form-field blank_content editor" name="'+index+'" rows="10" placeholder="Input content here" value="' + feedback + '"></textarea>'+
        '</div> </div>';
    $("#blankIndex").val(index.split("_")[1]);
    $(div).append(content);
    addKE(index);//add a new KindEditor
    KE.html('#feedback-'+index, feedback);
}

function addTrueFalse(data){
    var true_content = "";
    var true_feedback = "";
    var false_content = "";
    var false_feedback = "";
    var right = "true";
    var answer = $.parseJSON(data);
    if (answer.true_content != null && answer.feedback_true != null && answer.false_content != null && answer.feedback_false != null && answer.right != null ) {
        true_content = answer.true_content;
        true_feedback = answer.feedback_true;
        false_content = answer.false_content;
        false_feedback = answer.feedback_false;
        right = answer.right;
    }
    var truefalse_html =
            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">True</div>' +
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
            '<input type="text" id="true_content" class="am-form-field" value="'+true_content+'" />' +
            '</div></div>' +

            //KE
            '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">True Feedback</div>' +
                '<div class="am-u-sm-10">'+
                '<textarea id="feedback-true" class="am-form-field blank_content editor" name="feedback_true" rows="10" placeholder="Input content here" value="' + true_feedback + '"></textarea>'+
            '</div> </div>'+

            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">False</div>' +
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
            '<input type="text" id="false_content" class="am-form-field" value="'+false_content+'" />' +
            '</div></div>' +

                //KE
            '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">False Feedback</div>' +
                '<div class="am-u-sm-10">'+
                '<textarea id="feedback-false" class="am-form-field blank_content editor" name="feedback_false" rows="10" placeholder="Input content here" value="' + false_feedback + '"></textarea>'+
            '</div> </div>'+

            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">Right Answer</div>' +
            '<div class="am-u-sm-8 am-u-md-10">' +
            '<select  data-am-selected="{btnSize: \'sm\'}"  id="tf_answer" name="qc.answer" >' +
            '<option value="true">True</option>' +
            '<option value="false">False</option>' +
            '</select></div></div>'
        ;
    $(div).append(truefalse_html);
    $("#tf_answer").val(right);
    addKE("feedback_true");//add a new KindEditor
    addKE("feedback_false");//add a new KindEditor
    KE.html('#feedback-true', true_feedback);
    KE.html('#feedback-false', false_feedback);
}


function deleteBlank(index){

}

function addKE(ke_id){
    KE.ready(function(K) {
        ke_id = K.create('textarea[name="'+ke_id+'"]', {
            resizeType : 1,
            allowPreviewEmoticons : false,
            allowFileManager : true,
            allowUpload : true,
            filterMode: false,
            uploadJson : uploadPath(),
            imageUploadJson : uploadPath(),
            afterBlur: function(){this.sync();},
            items : [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist', '|', 'emoticons', 'image','multiimage', 'link','code']
        });
    });
}


var add_blank_button_html = '<div class="am-g am-margin-top">' +
    '<div class="am-u-sm-4 am-u-md-2 am-text-right">Add blank</div>' +
    '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
    '<input type="button" id="true" class="am-btn am-btn-success" value="Add one blank" onclick="addBlank()" />' +
    '</div></div>';

