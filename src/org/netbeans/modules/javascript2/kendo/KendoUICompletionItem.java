package org.netbeans.modules.javascript2.kendo;

import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author Petr Pisl
 */
public class KendoUICompletionItem implements CompletionProposal {
    
    static CompletionProposal createKendoUIItem(KendoUIDataItem item, int anchorOffset) {
        ElementHandle element = new KendoUIElement(item.getName(), item.getDocumentation(), ElementKind.PROPERTY);
        return new KendoUICompletionItem(item, anchorOffset, element);
    }
    
    private final int anchorOffset;
    private final ElementHandle element;
    private final KendoUIDataItem dataItem;

    public KendoUICompletionItem(KendoUIDataItem item, int anchorOffset, ElementHandle element) {
        this.anchorOffset = anchorOffset;
        this.element = element;
        this.dataItem = item;
    }

    @Override
    public int getAnchorOffset() {
        return anchorOffset;
    }

    @Override
    public ElementHandle getElement() {
        return element;
    }

    @Override
    public String getName() {
        return element.getName();
    }

    @Override
    public String getInsertPrefix() {
        return element.getName();
    }

    @Override
    public String getSortText() {
        return getName();
    }

    @Override
    public String getLhsHtml(HtmlFormatter formatter) {
        formatter.reset();
        formatter.appendText(getName());
        if (dataItem.getType() != null) {
            formatter.appendText(": "); //NOI18N
            formatter.type(true);
            formatter.appendText(dataItem.getType());
            formatter.type(false);
        }
        return formatter.getText();
    }

    @Messages("KendoUICompletionItem.lbl.kendoui.framework=Kendo UI")
    @Override
    public String getRhsHtml(HtmlFormatter formatter) {
        return Bundle.KendoUICompletionItem_lbl_kendoui_framework();
    }

    @Override
    public ElementKind getKind() {
        return element.getKind();
    }

    @Override
    public ImageIcon getIcon() {
        return ImageUtilities.loadImageIcon("org/netbeans/modules/javascript2/kendo/kendo.jpg", true);
    }

    @Override
    public Set<Modifier> getModifiers() {
        return element.getModifiers();
    }

    @Override
    public boolean isSmart() {
        return false;
    }

    @Override
    public int getSortPrioOverride() {
        return 22;
    }

    @Override
    public String getCustomInsertTemplate() {
        if (dataItem.getTemplate() != null) {
            return getName() + ": " + dataItem.getTemplate().trim(); //NOI18N
        }
        return null;
    }

    
}
