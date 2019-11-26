import "@vaadin/vaadin-charts/theme/vaadin-chart-default-theme.js";
import "@vaadin/vaadin-lumo-styles/all-imports.js";

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<dom-module id="common-styles">
  <template>
    <style include="lumo-color lumo-typography">
        kbd {
            font-family: var(--lumo-font-family);
            display: inline-block;
            background: var(--lumo-contrast-10pct);
            padding: var(--lumo-space-wide-xs);
            margin: 0 var(--lumo-space-wide-xs);
            border-radius: var(--lumo-border-radius-s);
            box-shadow: 0 0 0 1px var(--lumo-contrast-10pct), var(--lumo-box-shadow-xs);
            font-size: var(--lumo-font-size-m);
        }
    </style>
  </template>
</dom-module>

<custom-style>
  <style include="common-styles">
    html,
    body {
        height: 100%;
    }
  
    vaadin-app-layout vaadin-tab a:hover {
      text-decoration: none;
    }
  </style>
</custom-style>

<dom-module id="menu-bar-theme" theme-for="vaadin-menu-bar">
  <template>
    <style include="common-styles"></style>
  </template>
</dom-module>

<dom-module id="app-layout-theme" theme-for="vaadin-app-layout">
  <template>
    <style>
      :host([theme~="app-nav-layout"]) [part="navbar"] {
        align-items: center;
        justify-content: center;
      }
    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
