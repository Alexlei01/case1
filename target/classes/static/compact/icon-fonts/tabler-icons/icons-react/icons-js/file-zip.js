import * as React from "react";

function IconFileZip({
  size = 24,
  color = "currentColor",
  stroke = 2,
  ...props
}) {
  return <svg xmlns="http://www.w3.org/2000/svg" className="icon icon-tabler icon-tabler-file-zip" width={size} height={size} viewBox="0 0 24 24" strokeWidth={stroke} stroke={color} fill="none" strokeLinecap="round" strokeLinejoin="round" {...props}><desc>{"Download more icon variants from https://tabler-icons.io/i/file-zip"}</desc><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M6 20.735a2 2 0 0 1 -1 -1.735v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-1" /><path d="M11 17a2 2 0 0 1 2 2v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a2 2 0 0 1 2 -2z" /><line x1={11} y1={5} x2={10} y2={5} /><line x1={13} y1={7} x2={12} y2={7} /><line x1={11} y1={9} x2={10} y2={9} /><line x1={13} y1={11} x2={12} y2={11} /><line x1={11} y1={13} x2={10} y2={13} /><line x1={13} y1={15} x2={12} y2={15} /></svg>;
}

export default IconFileZip;