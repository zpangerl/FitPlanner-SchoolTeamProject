package main.java.memoranda;

import main.java.memoranda.util.Util;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

import java.io.File;
import java.util.Vector;

public class TrainersListImpl implements TrainersList{
    private Project _project = null;
    private Document _doc = null;
    private Element _root = null;
    public TrainersListImpl(Document doc, Project prj) {
        _doc = doc;
        _root = _doc.getRootElement();
        _project = prj;
    }
    public TrainersListImpl(Project prj) {
        _root = new Element("trainers-list");
        _doc = new Document(_root);
        _project = prj;
    }
    @Override
    public Vector getAllTrainers() {
        Vector v = new Vector();
        Elements rs = _root.getChildElements("trainer");
        for (int i = 0; i < rs.size(); i++)
            v.add(new Trainer(rs.get(i).getAttribute("name").getValue(), rs.get(i).getAttribute("position").getValue()));
        return v;
    }

    @Override
    public Trainer getTrainer(String name) {
        Elements rs = _root.getChildElements("trainer");
        for (int i = 0; i < rs.size(); i++)
            if (rs.get(i).getAttribute("name").getValue().equals(name))
                return new Trainer(rs.get(i).getAttribute("name").getValue(), rs.get(i).getAttribute("position").getValue());
        return null;
    }

    @Override
    public void addTrainer(String name, String position) {
        Element el = new Element("trainer");
        el.addAttribute(new Attribute("id", Util.generateId()));
        el.addAttribute(new Attribute("name", name));
        el.addAttribute(new Attribute("position", position));
        _root.appendChild(el);
    }

    @Override
    public void removeTrainer(String name) {
        Elements rs = _root.getChildElements("trainer");
        for (int i = 0; i < rs.size(); i++)
            if (rs.get(i).getAttribute("name").getValue().equals(name)) {
                _root.removeChild(rs.get(i));
            }
    }

    @Override
    public int getAllTrainersCount() {
        return _root.getChildElements("trainers").size();
    }

    @Override
    public Document getXMLContent() {
        return _doc;
    }
}
