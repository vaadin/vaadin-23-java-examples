package com.example.application.views;


import com.example.application.components.appnav.AppNav;
import com.example.application.components.appnav.AppNavItem;
import com.example.application.views.addressformjava.AddressFormJavaView;
import com.example.application.views.cardlistjava.CardListJavaView;
import com.example.application.views.chatjava.ChatJavaView;
import com.example.application.views.checkoutformjava.CheckoutFormJavaView;
import com.example.application.views.collaborativemasterdetailjava.CollaborativeMasterDetailJavaView;
import com.example.application.views.collaborativemasterdetailsampleaddressjava.CollaborativeMasterDetailSampleAddressJavaView;
import com.example.application.views.collaborativemasterdetailsamplebookjava.CollaborativeMasterDetailSampleBookJavaView;
import com.example.application.views.creditcardformjava.CreditCardFormJavaView;
import com.example.application.views.dashboardjava.DashboardJavaView;
import com.example.application.views.emptyjava.EmptyJavaView;
import com.example.application.views.gridwithfiltersjava.GridwithFiltersJavaView;
import com.example.application.views.helloworldjava.HelloWorldJavaView;
import com.example.application.views.imagelistjava.ImageListJavaView;
import com.example.application.views.listjava.ListJavaView;
import com.example.application.views.mapjava.MapJavaView;
import com.example.application.views.masterdetailjava.MasterDetailJavaView;
import com.example.application.views.masterdetailsampleaddressjava.MasterDetailSampleAddressJavaView;
import com.example.application.views.masterdetailsamplebookjava.MasterDetailSampleBookJavaView;
import com.example.application.views.personformjava.PersonFormJavaView;
import com.example.application.views.richtexteditorjava.RichTextEditorJavaView;
import com.example.application.views.spreadsheetjava.SpreadsheetJavaView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Vaadin 23 Java Examples");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private AppNav createNavigation() {
        // AppNav is not yet an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Empty (Java)", EmptyJavaView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(
                new AppNavItem("Hello World (Java)", HelloWorldJavaView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(
                new AppNavItem("Dashboard (Java)", DashboardJavaView.class, LineAwesomeIcon.CHART_AREA_SOLID.create()));
        nav.addItem(new AppNavItem("Card List (Java)", CardListJavaView.class, LineAwesomeIcon.LIST_SOLID.create()));
        nav.addItem(new AppNavItem("List (Java)", ListJavaView.class, LineAwesomeIcon.TH_SOLID.create()));
        nav.addItem(new AppNavItem("Master-Detail (Java)", MasterDetailJavaView.class,
                LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new AppNavItem("Master-Detail SampleAddress (Java)", MasterDetailSampleAddressJavaView.class,
                LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new AppNavItem("Master-Detail SampleBook (Java)", MasterDetailSampleBookJavaView.class,
                LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new AppNavItem("Collaborative Master-Detail (Java)", CollaborativeMasterDetailJavaView.class,
                LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new AppNavItem("Collaborative Master-Detail SampleAddress (Java)",
                CollaborativeMasterDetailSampleAddressJavaView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new AppNavItem("Collaborative Master-Detail SampleBook (Java)",
                CollaborativeMasterDetailSampleBookJavaView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new AppNavItem("Person Form (Java)", PersonFormJavaView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new AppNavItem("Address Form (Java)", AddressFormJavaView.class,
                LineAwesomeIcon.MAP_MARKER_SOLID.create()));
        nav.addItem(new AppNavItem("Credit Card Form (Java)", CreditCardFormJavaView.class,
                LineAwesomeIcon.CREDIT_CARD.create()));
        nav.addItem(new AppNavItem("Map (Java)", MapJavaView.class, LineAwesomeIcon.MAP.create()));
        nav.addItem(
                new AppNavItem("Spreadsheet (Java)", SpreadsheetJavaView.class, LineAwesomeIcon.FILE_EXCEL.create()));
        nav.addItem(new AppNavItem("Chat (Java)", ChatJavaView.class, LineAwesomeIcon.COMMENTS.create()));
        nav.addItem(
                new AppNavItem("Rich Text Editor (Java)", RichTextEditorJavaView.class, LineAwesomeIcon.EDIT.create()));
        nav.addItem(
                new AppNavItem("Image List (Java)", ImageListJavaView.class, LineAwesomeIcon.TH_LIST_SOLID.create()));
        nav.addItem(new AppNavItem("Checkout Form (Java)", CheckoutFormJavaView.class,
                LineAwesomeIcon.CREDIT_CARD.create()));
        nav.addItem(new AppNavItem("Grid with Filters (Java)", GridwithFiltersJavaView.class,
                LineAwesomeIcon.FILTER_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
