package org.netbeans.modules.javascript2.kendo;

public class KendoDataItem {

    private final String parent;

    private final String name;
    private final String type;
    private final String documentation;
    private final String template;

    public KendoDataItem(String parent, String name, String type, String documentation, String template) {
        this.parent = parent;
        this.name = name;
        this.type = type;
        this.documentation = documentation;
        this.template = template;
    }

    public String getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTemplate() {
        return template;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.parent != null ? this.parent.hashCode() : 0);
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KendoDataItem other = (KendoDataItem) obj;
        if ((this.parent == null) ? (other.parent != null) : !this.parent.equals(other.parent)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
