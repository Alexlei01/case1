import * as React from "react";

function IconExternalLink({
  size = 24,
  color = "currentColor",
  stroke = 2,
  ...props
}) {
  return <svg xmlns="http://www.w3.org/2000/svg" className="icon icon-tabler icon-tabler-external-link" width={size} height={size} viewBox="0 0 24 24" strokeWidth={stroke} stroke={color} fill="none" strokeLinecap="round" strokeLinejoin="round" {...props}><desc>{"Download more icon variants from https://tabler-icons.io/i/external-link"}</desc><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M11 7h-5a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-5" /><line x1={10} y1={14} x2={20} y2={4} /><polyline points="15 4 20 4 20 9" /></svg>;
}

export default IconExternalLink;