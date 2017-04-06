(function(){
	'use strict';
	var root = typeof window === 'object' ? window : {};

	var htmlEncode = function(value, entry) {
		if(!entry){
			entry = { "'": "&apos;", '"': '&quot;', '<': '&lt;', '>': '&gt;' };
		}

		if(value){
			value = value.replace(/(['")-><&\\\/\.])/g, function ($0) { return entry[$0] || $0; });
		}
		return value;
	}

	if(root){
		root.htmlEncode = htmlEncode;
	}

})();