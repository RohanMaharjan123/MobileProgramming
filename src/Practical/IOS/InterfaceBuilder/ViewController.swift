//
//  ViewController.swift
//  InterFaceBuilder
//
//  Created by Rohan Maharjan on 8/13/24.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var LabelMsg: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnPressed(_ sender: Any) {
        LabelMsg.text = "Button Pressed"

    }
}

