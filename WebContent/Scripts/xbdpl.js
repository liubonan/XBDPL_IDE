/*
 * JsMin
 * Javascript Compressor
 * http://www.crockford.com/
 * http://www.smallsharptools.com/
*/

dp.sh.Brushes.Java=function()
{var keywords='bool big small file void '+'if else for return infileopen outfileopen infileclose outfileclose '+'input output true false';
this.regexList=[{regex:dp.sh.RegexLib.SingleLineCComments,css:'comment'},{regex:dp.sh.RegexLib.DoubleQuotedString,css:'string'},{regex:new RegExp('\\b([\\d]+(\\.[\\d]+)?|0x[a-f0-9]+)\\b','gi'),css:'number'},{regex:new RegExp(this.GetKeywords(keywords),'gm'),css:'keyword'}];
this.CssClass='dp-j';this.Style='.dp-j .annotation { color: #646464; }'+'.dp-j .number { color: #C00000; }';}
dp.sh.Brushes.Java.prototype=new dp.sh.Highlighter();dp.sh.Brushes.Java.Aliases=['java'];



