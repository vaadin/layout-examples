import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button';

/**
 * `intro-view`
 *
 * IntroView element.
 *
 * @customElement
 * @polymer
 */
class IntroView extends PolymerElement {

    static get template() {
        return html`
            <style include="common-styles">
                :host {
                    display: block;
                }
                
                .wrapper {
                    margin: 0 auto;
                    max-width: 960px;
                    padding: 0 var(--lumo-space-m);
                }
            </style>
            <main class="wrapper">
                <h1>Layout Examples for Vaadin 14</h1>
                
                <p>
                    All of the examples are viewable with two themes (light and dark).
                    Toggle between the themes by clicking the button below or by pressing <kbd>T</kbd> on your keyboard.
                </p>
                <p><vaadin-button on-click="toggleTheme">Toggle Theme</vaadin-button></p>
                
                <h2>Basic examples</h2>
                <p>
                    Examples showcasing individual building blocks or specific features for creating layouts.
                    Note that the examples marked with "CSS Grid" are implemented using
                    <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout">CSS Grid Layout</a>
                    which is a very flexible way to create layouts but notably doesn't work in IE 11, Safari 9 or older browsers. 
                </p>
                <ul>
                    <li><a router-link href="three-columns">Three Columns</a> (CSS Grid) - A grid layout with header, footer and two sidebars</li>
                    <li><a router-link href="two-columns">Two Columns</a> (CSS Grid) - A grid layout with header, footer and one sidebar</li>
                </ul>
                
                <h2>Complete layout examples</h2>
                <p>Styled ready to use layouts which you may use as is or customize to your liking.</p>
                <ul>
                    <li><a router-link href="pricing">Pricing</a></li>
                    <li><a router-link href="fixed-nav-sticky-footer">Fixed Nav &amp; Sticky Footer</a></li>
                </ul>
            </main>
        `;
    }

    static get is() {
        return 'intro-view';
    }

    toggleTheme() {
        window.utils.toggleTheme();
    }
}

customElements.define(IntroView.is, IntroView);
