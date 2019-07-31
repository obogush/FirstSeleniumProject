package Brite_ERP;

public class Paths {

    public String actionButtonLocator = "//button[contains(text(),'Action')]";
    public String okLocator = "//span[text()='Ok']";
    public String CrmButton = "//span[@class='oe_menu_text' and contains(text(),'CRM')]";

    public String pipelineButton = "//li[@class='active']//span[@class='oe_menu_text'][contains(text(),'Pipeline')]";
    public String listButton = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    public String listNewTotals = "tr:nth-child(3) > td:nth-child(9)";
    public String pivotButton = "//button[@class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']";
    public String pivotNewTotals = "tr:nth-child(2) > td:nth-child(2)";
}

