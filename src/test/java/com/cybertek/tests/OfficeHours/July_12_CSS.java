package com.cybertek.tests.OfficeHours;

import org.testng.annotations.Test;

public class July_12_CSS {

    /*

    css:
            mainly uses: HTML tag, id, Attributes, class

            benifits:
                    faster than xpath, easier to read.
                        it's also used more often like xpath

            write xpath with attributes:
                              //tagname[@Attribue='value']
                     if not unique:      //tagname[@Attribue='value' and @Attribute2='value']

Values Can not strat with numbers in css
          write css with attribute:
                        tagname[Attribute=Value]      // double quote or single qoute is not neccessary
           if not unique :   tagname[Attribute=Value][Attribut2=Value]


        write csss with parent and child tagnames:
                    parentTagname childtagname[Attribute=Value]

        write css with ID: if the id contains multiple digits, it's mostlikely to be dynamic
                in css # represents your id
                    formula:  tagname#IDValue

        write css with id and attribute: we use it if the id is not unique
                formula:  tagname#idvalue[Attribute=Value]


        write css with class:
                        . sighn is for class
                      formula:  tagname.ClassValue

        write css with class and attribute:   if the class is not unique
               formula:  tagname.ClassValue[Attribute=Value]


        write csss with start with condition:
                    ^ sign is for "starting with:
                    formula:  tagname[Attribute^=StartValue]

        write css with ends with condition:
                $ sign is for ends with:
                formula: tagname[Attribute$=endingValue]

        write css with contains condition:
                * sign is for contains condition
                fromula: tagname[Attribute*=someValue]

     */

        /*
        <span>
        <select aria-label="Month" name="birthday_month" id="month" title="Month" class="_5dba">
                        css: select[aria-label=Month]
                        css: select[aria-label=Month][name=birthday_month]
                        css: span select[aria-label=Month]
                        css: select#month
                        css: select#month[aria-label=Month]
                        css: select._5dba       // not unique
                        css: select._5dba[title=Month]
                        css: select[name^=birt]  // not unique
                        css: select[name^=birt][ aria-label^=Mon]
                        css: select[name$=nth]
                        css: select[name$=nth][name^=birt]
                        css: select[name*=day]
                        css: select[[name*=day][aria-label$=th][title^=M]

                        css: span select._5dba[aria-label$=th][title^=M]



         */

    @Test
    public void test1()
    {

    }


}
