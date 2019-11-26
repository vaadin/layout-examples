import '@vaadin/vaadin-charts/theme/vaadin-chart-default-theme.js';
import '@vaadin/vaadin-lumo-styles/all-imports.js';

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<dom-module id="common-styles">
  <template>
    <style include="lumo-color lumo-typography"></style>
  </template>
</dom-module>

<custom-style>
  <style include="common-styles">
    html,
    body {
        height: 100%;
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
