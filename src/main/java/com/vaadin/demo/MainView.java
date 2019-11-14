package com.vaadin.demo;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.artur.github_corner.GitHubCorner;
import org.vaadin.googleanalytics.tracking.EnableGoogleAnalytics;

import com.vaadin.demo.views.FixedNavStickyFooterView;
import com.vaadin.demo.views.IntroView;
import com.vaadin.demo.views.PricingView;
import com.vaadin.demo.views.ThreeColumnsView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./styles/shared-styles.js")
@JsModule("./src/utils.js")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@EnableGoogleAnalytics(value = "UA-658457-6", pageviewPrefix = "layout-examples/")
@BodySize
public class MainView extends AppLayout implements AfterNavigationObserver {

    private final Tabs menu;

    public MainView() {
        menu = createMenuTabs();
        addToNavbar(new Button("Toggle theme", buttonClickEvent -> getElement().executeJs("window.utils.toggleTheme();")));
        addToNavbar(menu);
        addToNavbar(new GitHubCorner("vaadin", "layout-examples"));
    }

    private static Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.add(getAvailableTabs());
        return tabs;
    }

    private static Tab[] getAvailableTabs() {
        final List<Tab> tabs = new ArrayList<>();
        tabs.add(createTab("Intro", IntroView.class));
        tabs.add(createTab("ThreeColumns", ThreeColumnsView.class));
        tabs.add(createTab("Pricing", PricingView.class));
        tabs.add(createTab("Fixed Nav & Sticky Footer", FixedNavStickyFooterView.class));
        return tabs.toArray(new Tab[tabs.size()]);
    }

    private static Tab createTab(String title,
            Class<? extends Component> viewClass) {
        return createTab(new RouterLink(title, viewClass));
    }

    private static Tab createTab(Component content) {
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Select the matching navigation tab on page load
        String location = event.getLocation().getFirstSegment();
        menu.getChildren().forEach(component -> {
            if (component instanceof Tab) {
                Tab tab = (Tab) component;
                tab.getChildren().findFirst().ifPresent(component1 -> {
                    if (component1 instanceof RouterLink) {
                        RouterLink link = (RouterLink) component1;
                        if (link.getHref().equals(location)) {
                            menu.setSelectedTab(tab);
                        }
                    }
                });
            }
        });
    }
}
