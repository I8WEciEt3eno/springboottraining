/**
 * アイコンmouseover時のevent
 * 青いアイコン画像(xxx_blue.jpg)を橙のアイコン画像(xxx_orange.jpg)に入れ替え, 橙のラインで縁取りする
 */
function iconMouseover(obj) {
	const src = obj.getAttribute('src')
	if (src.match(/_blue.jpg$/g)) {
		const newSrc = src.replace(/_blue.jpg$/g, "_orange.jpg");
		obj.setAttribute('src',newSrc);
		obj.style.outline = '2px solid orange';
	}
}

/**
 * アイコンmouseout時のevent
 * 橙のアイコン画像(xxx_orange.jpg)を青いアイコン画像(xxx_blue.jpg)に入れ替え, 縁取りを消去する
 */
function iconMouseout(obj) {
	const src = obj.getAttribute('src')
	if (src.match(/_orange.jpg$/g)) {
		const newSrc = src.replace(/_orange.jpg$/g, "_blue.jpg");
		obj.setAttribute('src',newSrc);
		obj.style.outline = '';
	}
}