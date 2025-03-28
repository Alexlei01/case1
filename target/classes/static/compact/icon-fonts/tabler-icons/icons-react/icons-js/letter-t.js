import * as React from "react";

function IconLetterT({
  size = 24,
  color = "currentColor",
  stroke = 2,
  ...props
}) {
  return <svg xmlns="http://www.w3.org/2000/svg" className="icon icon-tabler icon-tabler-letter-t" width={size} height={size} viewBox="0 0 24 24" strokeWidth={stroke} stroke={color} fill="none" strokeLinecap="round" strokeLinejoin="round" {...props}><desc>{"Download more icon variants from https://tabler-icons.io/i/letter-t"}</desc><path stroke="none" d="M0 0h24v24H0z" fill="none" /><line x1={6} y1={4} x2={18} y2={4} /><line x1={12} y1={4} x2={12} y2={20} /></svg>;
}

export default IconLetterT;