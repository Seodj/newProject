// var data = convertFormDataToObject("recipientSimpleForm"); 
function convertFormDataToObject(formId) {
	var paramObj = {};
	$.each($('#' + formId).serializeArray(), function(_, kv) {
		var param = paramObj[kv.name];
		if (param == null) {
			paramObj[kv.name] = kv.value;
		} else if (param instanceof Array) {
			paramObj[kv.name].push(kv.value);
		} else {
			paramObj[kv.name] = [param, kv.value];
		}
		
	});
	return paramObj;
}