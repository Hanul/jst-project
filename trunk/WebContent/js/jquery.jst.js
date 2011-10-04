var __rsa_key__;

jQuery.fn.secure = function() {
	
	if (__rsa_key__ == null) {
		__rsa_key__ = new RSAKey(); // RSA 키 생성
		__rsa_key__.setPublic(publicKeyModulus, publicKeyExponent);
	}
	
	this.submit(function(){
		
		var $form = $('<form method="post"/>').hide(); // 임시 폼을 새로 생성한다.
		
		// input 태그 내용을 옮긴다.
		var formAppendInput = function(name, value) {
			$form.append('<input type="hidden" name="' + name + '" value="' + __rsa_key__.encrypt(value) + '">');
		};
		$(this).find('input').each(function(){
			formAppendInput($(this).attr('name'), $(this).val());
		});
		
		// textarea 태그 내용을 옮긴다.
		var formAppendTextarea = function(name, value) {
			$form.append('<textarea name="' + name + '">' + __rsa_key__.encrypt(value) + '</textarea>').hide();
		};
		$(this).find('textarea').each(function(){
			formAppendTextarea($(this).attr('name'), $(this).val());
		});
		
		// 인증 쿼리를 포함한다.
		formAppendInput(SECURED_QUERY_NAME, 'true');
		$form.submit(); // 폼 전송
		
		return false;
	});
	
};